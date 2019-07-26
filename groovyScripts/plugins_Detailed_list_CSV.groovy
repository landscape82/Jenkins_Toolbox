println "NAME:|VERSION:|DESCRIPTION:|DEPENDENCY:"
jenkins.model.Jenkins.instance.getPluginManager().getPlugins().stream().sorted().each
{ println "${it.getShortName()}|${it.getVersion()}|${it.getDisplayName()}|${it.getDependencies()}" }