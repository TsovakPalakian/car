package framework.classcore.helper;

import java.lang.annotation.Annotation;
import java.util.List;

import framework.FrameworkConstant;
import framework.classcore.ClassScanner;
import framework.webcore.util.InstanceFactory;

public class ClassHelper {
	
	private static final ClassScanner classScanner = InstanceFactory.getClassScanner();
	
	public static List<Class<?>> getBasePackageClassList() {
        return classScanner.getClassList(FrameworkConstant.PACKAGE_CLASSES);
    }

    public static List<Class<?>> getClassListBySuper(Class<?> superClass) {
        return classScanner.getClassListBySuper(FrameworkConstant.PACKAGE_CLASSES, superClass);
    }

    public static List<Class<?>> getClassListByAnnotation(Class<? extends Annotation> annotationClass) {
        return classScanner.getClassListByAnnotation(FrameworkConstant.PACKAGE_CLASSES, annotationClass);
    }
}
