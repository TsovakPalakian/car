package framework.classcore.template;

import java.util.ArrayList;
import java.util.List;

import static framework.FrameworkConstant.*;
import framework.util.ClassUtil;
import framework.webcore.DataContext;

public abstract class ClassTemplate extends Template {

	public ClassTemplate(String packageName) {
		super(packageName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getFileList() {
		List<Class<?>> classList = new ArrayList<>();
		searchFiles(DataContext.getServletContext(), WEB_INF_CLASSES, classList);
		searchClassFiles(DataContext.getServletContext(), classList);
		return (List<T>) classList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> void doAddFile(List<T> fileList, String fileName) {
		if (fileName.startsWith(WEB_INF_CLASSES)) {
			fileName = fileName.replaceAll(WEB_INF_CLASSES, EMPTY_STRING);
		}
		fileName = fileName.replaceAll(CLASS_PREFIX, EMPTY_STRING).replaceAll(SLASH, DOT);
		Class<?> clzz = ClassUtil.loadClass(fileName);
		if (checkAddClass(clzz)) {
			fileList.add((T) clzz);
		}
	}

	protected abstract boolean checkAddClass(Class<?> clz);
}
