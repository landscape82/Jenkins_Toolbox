def pluginByName = jenkins.model.Jenkins.instance.getPluginManager().getPlugin('jdk-tool');
println "${pluginByName.getShortName()} (${pluginByName.getVersion()}) - ${pluginByName.getDependencies()}"
