package framework.classcore.template;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.servlet.ServletContext;

import framework.util.ClassUtil;
import framework.util.ObjectUtils;

import static framework.FrameworkConstant.*;

public abstract class Template {

	protected final String packageName;

	public Template(String packageName) {
		super();
		this.packageName = packageName;
	}

	protected void searchFiles(ServletContext context, String resourcePath, List<?> fileList) {
		Set<String> contextList = context.getResourcePaths(resourcePath);
		Set<String> linkedSet = new HashSet<>();
		if (ObjectUtils.isNotNullObject(contextList)) {
			linkedSet.addAll(contextList);
		}

		for (String fileName : linkedSet) {
			if (fileName.endsWith(SLASH)) {
				searchFiles(context, fileName, fileList);
			} else {
				doAddFile(fileList, fileName);
			}
		}
	}

	protected void searchClassFiles(ServletContext context, List<?> classList) {
		try {
			Enumeration<URL> urls = ClassUtil.getClassLoader().getResources(packageName.replace(DOT, SLASH));
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				if (url != null) {
					String protocal = url.getProtocol();
					if (protocal.equals(JAR)) {
						JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
						JarFile jarFile = jarURLConnection.getJarFile();
						Enumeration<JarEntry> jarEntries = jarFile.entries();
						while (jarEntries.hasMoreElements()) {
							JarEntry jarEntry = jarEntries.nextElement();
							String jarEntryName = jarEntry.getName();
							if (jarEntryName.endsWith(CLASS_PREFIX)) {
								String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(DOT))
										.replaceAll(SLASH, DOT);
								if (className.startsWith(PACKAGE_CLASSES)) {
									doAddFile(classList, className);
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
		}
	}

	protected abstract <T> List<T> getFileList();

	protected abstract <T> void doAddFile(List<T> classList, String className);

}
