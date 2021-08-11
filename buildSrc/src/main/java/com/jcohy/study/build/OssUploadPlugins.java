package com.jcohy.study.build;

import com.jcohy.oss.OssUploadPlugin;
import com.jcohy.oss.OssUploadTask;
import com.jcohy.oss.dsl.AliOssExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * <p> 描述: .
 * Copyright: Copyright (c) 2021.
 * <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 * @author jiac
 * @version 1.0.0 2021/8/11:12:54
 * @since 1.0.0
 */
public class OssUploadPlugins implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		project.getPlugins().apply(OssUploadPlugin.class);
		project.getTasks().withType(OssUploadTask.class, (ossUploadTask) -> {
			ossUploadTask.dependsOn("aggregatedAsciidoctor");
		});
		AliOssExtension extension = project.getExtensions().getByType(AliOssExtension.class);
		extension.setBucket("jcohy-study");
		String buildDir = project.getRootProject().getBuildDir().getName();
		extension.getUpload().setSource(buildDir+"/generated");
		extension.getUpload().setPrefix("");

		extension.getUpload().setIgnoreSourceDir(true);
	}
}
