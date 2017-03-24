package com.nutz.pip.common.scan;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClassUtils {
	private static final String CLASS_EXT = ".class";
	private static final String JAR_FILE_EXT = ".jar";
	private static final String ERROR_MESSAGE = "packageName can't be null";
	private static final String DOT = ".";
	private static final String ZIP_SLASH = "/";
	private static final String BLACK = "";
	private static final ClassFilter NULL_CLASS_FILTER = null;

	private static FileFilter fileFilter = new FileFilter() {

		public boolean accept(File pathname) {
			// TODO Auto-generated method stub
			return false;
		}

	};

	private static void ckeckNullPackageName(String packageName) {
		if (packageName == null || packageName.trim().length() == 0) {
			throw new NullPointerException(ERROR_MESSAGE);
		}
	}

	private static String getWellFormedPackageName(String packageName) {
		return packageName.lastIndexOf(DOT) != packageName.length() - 1 ? packageName
				+ DOT
				: packageName;
	}

	public static List<Class> scanPackage(String packageName,
			ClassFilter classFilter) {

		ckeckNullPackageName(packageName);

		final List<Class> classes = new ArrayList<Class>();

		for (String classPath : getClassPathArray()) {
			fillClasses(new File(classPath),
					getWellFormedPackageName(packageName), classFilter, classes);
		}
		return classes;
	}

	private static void fillClasses(File file, String packageName,
			ClassFilter classFilter, List<Class> classes) {
		if (isDirectory(file)) {
			processDirectory(file, packageName, classFilter, classes);
		} else if (isClass(file.getName())) {
			processClassFile(file, packageName, classFilter, classes);
		} else if (isJarFile(file.getName())) {
			processJarFile(file, packageName, classFilter, classes);
		}
	}

	private static void processDirectory(File directory, String packageName,
			ClassFilter classFilter, List<Class> classes) {
		for (File file : directory.listFiles(fileFilter)) {
			fillClasses(file, packageName, classFilter, classes);
		}
	}

	private static void processClassFile(File file, String packageName,
			ClassFilter classFilter, List<Class> classes) {
		final String filePathWithDot = file.getAbsolutePath().replace(
				File.separator, DOT);
		int subIndex = -1;

		if ((subIndex = filePathWithDot.indexOf(packageName)) != -1) {
			final String className = filePathWithDot.substring(subIndex)
					.replace(CLASS_EXT, BLACK);
			fillClass(className, packageName, classes, classFilter);
		}
	}

	private static void processJarFile(File file, String packageName,
			ClassFilter classFilter, List<Class> classes) {
		try {
			for (ZipEntry entry : Collections.list(new ZipFile(file).entries())) {
				if (isClass(entry.getName())) {
					final String className = entry.getName().replace(ZIP_SLASH,
							DOT).replace(CLASS_EXT, BLACK);
					fillClass(className, packageName, classes, classFilter);
				}
			}
		} catch (Throwable ex) {

		}
	}

	private static void fillClass(String className, String packageName,
			List<Class> classes, ClassFilter classFilter) {
		if (checkClassName(className, packageName)) {
			try {
				final Class clazz = Class.forName(className, Boolean.FALSE,
						ClassUtils.class.getClassLoader());
				if (checkClassFilter(classFilter, clazz)) {
					classes.add(clazz);
				}
			} catch (Throwable ex) {

			}
		}
	}

	public static List<Class> scanPackage(String packageName) {
		return scanPackage(packageName, NULL_CLASS_FILTER);
	}

	private static String[] getClassPathArray() {
		return System.getProperty("java.class.path").split(
				System.getProperty("path.separator"));

	}

	private static boolean checkClassName(String className, String packageName) {
		return className.indexOf(packageName) == 0;
	}

	private static boolean checkClassFilter(ClassFilter classFilter, Class clazz) {
		return classFilter == NULL_CLASS_FILTER || classFilter.accept(clazz);
	}

	private static boolean isClass(String fileName) {
		return fileName.endsWith(CLASS_EXT);
	}

	private static boolean isDirectory(File file) {
		return file.isDirectory();
	}

	private static boolean isJarFile(String fileName) {
		return fileName.endsWith(JAR_FILE_EXT);
	}

}
