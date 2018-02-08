package by.htp.itacademy.car.annotation.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;

import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.TreeMaker;

import by.htp.itacademy.car.annotation.util.DevLog;

@SupportedAnnotationTypes(value = FillingInDataProcessor.ANNOTATION_TYPE)
public class FillingInDataProcessor extends AbstractProcessor {

	public static final String ANNOTATION_TYPE = "by.htp.itacademy.car.annotation.FillingInData";
	private final static DevLog log = new DevLog("C:/1/logFillingInDataProcessor.txt");
	
	private JavacProcessingEnvironment javacProcessingEnv;
	private TreeMaker maker;

	@Override
	public void init(ProcessingEnvironment procEnv) {
		super.init(procEnv);
		this.javacProcessingEnv = (JavacProcessingEnvironment) procEnv;
		this.maker = TreeMaker.instance(javacProcessingEnv.getContext());
	}
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		log.logRewrite(annotations);
		return false;
	}
	
	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}
}
