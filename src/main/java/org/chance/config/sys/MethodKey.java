package org.chance.config.sys;

import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * Created by wqg on 2016/3/27.
 */
public class MethodKey {
    private String className;
    private String methodName;

    public MethodKey() {
    }

    public MethodKey(String fullName) {
        this.className = StringUtils.stripFilenameExtension(fullName);
        this.methodName = StringUtils.getFilenameExtension(fullName);
    }

    public MethodKey(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    public MethodKey(Method method) {
        super();
        this.className = method.getDeclaringClass().getName();
        this.methodName = method.getName();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getFullMethodName(){
        return this.className+"."+this.methodName;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  MethodKey)) return false;
        MethodKey target = (MethodKey) obj;

        if(this.className.equals(target.getClassName()) &&
                this.methodName.equals(target.getMethodName()))return true;

        return false;
    }

    //自动生成的
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        MethodKey methodKey = (MethodKey) o;
//
//        if (className != null ? !className.equals(methodKey.className) : methodKey.className != null) return false;
//        return !(methodName != null ? !methodName.equals(methodKey.methodName) : methodKey.methodName != null);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = className != null ? className.hashCode() : 0;
//        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
//        return result;
//    }
}
