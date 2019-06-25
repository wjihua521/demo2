package com.example.demo2.customer;

import com.example.demo2.constraint.MyTestAnnotation;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class MyAnnotationPaser {
    private static final Set<Class<? extends Annotation>> myAnnotations = new LinkedHashSet<Class<? extends Annotation>>();
    {
        myAnnotations.add(MyTestAnnotation.class);
    }

    public Collection<MyAnnotationOperation> paserMyAnnotation(Method method){
        Collection<? extends Annotation> collections = AnnotatedElementUtils.getAllMergedAnnotations(method,myAnnotations);
        Collection<MyAnnotationOperation> retValues = new ArrayList<>(2);
        collections.stream().filter(ann->ann instanceof MyTestAnnotation).forEach(item->retValues.add(paser((MyTestAnnotation) item,method)));
        //collections.parallelStream();
        return retValues;
    }

    private MyAnnotationOperation paser(MyTestAnnotation ann, AnnotatedElement ae){
        MyAnnotationOperation operation = new MyAnnotationOperation();
        operation.setKey(ann.key());
        operation.setValue(ann.value());
        operation.setManagerName(ann.managerName());
        operation.setName(ae.toString());
        return  operation;
    }
}
