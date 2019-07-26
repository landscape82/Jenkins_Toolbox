jenkins.model.Jenkins.instance.getPluginManager().getFailedPlugins().each {
    println "${it.getShortName()} (${it.getVersion()})}"
}
