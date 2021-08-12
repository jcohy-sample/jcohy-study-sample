package com.jcohy.study.build;

import java.util.Collections;

import com.jcohy.convention.conventions.ConventionsPlugin;
import com.jcohy.convention.deployed.DeployedPlugin;
import com.jcohy.convention.optional.OptionalDependenciesPlugin;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.plugins.JavaLibraryPlugin;
import org.gradle.api.plugins.PluginContainer;

/**
 * Copyright: Copyright (c) 2021.
 * <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 * <p>
 * Description:
 *
 * @author jiac
 * @version 1.0.0 2021/7/7:14:40
 * @since 1.0.0
 */
public class JavaModulePlugins implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        PluginContainer plugins = project.getPlugins();
        plugins.apply(JavaLibraryPlugin.class);
        plugins.apply(ConventionsPlugin.class);
        plugins.apply(DeployedPlugin.class);
        plugins.apply(OptionalDependenciesPlugin.class);
        configureDependencyManagement(project);
    }

    private void configureDependencyManagement(Project project) {
        Dependency flightFrameworkParent = project.getDependencies().enforcedPlatform(project.getDependencies()
                .project(Collections.singletonMap("path", ":bom")));
        project.getConfigurations().getByName("dependencyManagement", (dependencyManagement) -> {
            dependencyManagement.getDependencies().add(flightFrameworkParent);
        });
    }
}
