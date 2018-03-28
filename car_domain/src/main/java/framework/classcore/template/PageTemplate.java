package framework.classcore.template;

import java.util.ArrayList;
import java.util.List;

import framework.webcore.DataContext;

import static framework.FrameworkConstant.*;

public abstract class PageTemplate extends Template {

	public PageTemplate(String packageName) {
		super(packageName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getFileList() {
		List<String> pageList = new ArrayList<>();
		searchFiles(DataContext.getServletContext(), PATH_PAGES, pageList);
		return (List<T>) pageList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> void doAddFile(List<T> fileList, String fileName) {
		if (checkAddPage(fileName)) {
			fileList.add((T) fileName);
		}
	}

	protected abstract boolean checkAddPage(String pageName);
}
