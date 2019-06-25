package com.example.demo2.customer;

import com.example.demo2.dto.UserInfoDto;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

public class MyMethodInterceptor implements MethodInterceptor {
    private MyAnnotationPaser paser = new MyAnnotationPaser();
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Collection<MyAnnotationOperation> operations = paser.paserMyAnnotation(invocation.getMethod());
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        operations.stream().forEach(ann->paser(ann,invocation.getThis(),invocation.getArguments(),invocation.getMethod(),discoverer));
        return invocation.proceed();
    }

    private void paser(MyAnnotationOperation ann, Object target, Object[] args, Method method,LocalVariableTableParameterNameDiscoverer discoverer){
        System.out.println("----paser before: "+ann.toString());
        String[] paramNames = discoverer.getParameterNames(method);
        if(paramNames!=null && paramNames.length>0){
            ExpressionParser ep = new SpelExpressionParser();
            EvaluationContext ctx = new StandardEvaluationContext();
            Index index = new Index();
            Arrays.stream(paramNames).forEach(p->{
                ctx.setVariable(p,args[index.getIndex()]);
                index.setIndex(index.getIndex()+1);
            });
            if(StringUtils.hasText(ann.getValue())){
                Object nValue = ep.parseExpression(ann.getValue()).getValue(ctx);
                ann.setValue(nValue.toString());
            }
            if(StringUtils.hasText(ann.getKey())){
                Object nKey = ep.parseExpression(ann.getKey()).getValue(ctx);
                ann.setKey(nKey.toString());
            }
            System.out.println("----paser after: "+ann.toString());
        }
    }

    private class Index{
        private int index = 0;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
