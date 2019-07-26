import jenkins.model.Jenkins

println "\nINSTALLED:\n---"
println "Plugin name;Version;Description;Dependencies"
/**
 * Get the list of installed plugins.
 */
Jenkins.instance.getPluginManager().getPlugins().stream().sorted().each {
    println "${it.getShortName()};${it.getVersion()};${it.getDisplayName()};${it.getDependencies()}"
}

println "\nFAILED:\n---"
println "Plugin name; Version;Description;Dependencies"
/**
 * Get failed plugins: getFailedPlugins().sorted()
 */
Jenkins.instance.getPluginManager().getFailedPlugins().stream().sorted().each {
    println "${it.getShortName()};${it.getVersion()};${it.getDisplayName()};${it.getDependencies()}"
}

println "\nPINNED:\n---"
println "Plugin name;Version;Description;Dependencies"
/**
 * Get pinned plugins: isPinned()
 */
Jenkins.instance.getPluginManager().getPlugins()
        .findAll { plugin -> plugin.isPinned() }
        .each {
    println "${it.getShortName()};${it.getVersion()};${it.getDisplayName()};${it.getDependencies()}"
}

println "\nBUNDLED:\n---"
println "Plugin name; Version;Description;Dependencies"
/**
 * Get bundled plugins: isBundled()
 */
Jenkins.instance.getPluginManager().getPlugins()
        .findAll { plugin -> plugin.isBundled() }
        .each {
    println "${it.getShortName()};${it.getVersion()};${it.getDisplayName()};${it.getDependencies()}"
};

println "\nFORCED BY PINNING:\n---"
println "Plugin name;Version;Description;Dependencies"
/**
 * Get plugins forced to an older version because of Pinning
 */
Jenkins.instance.getPluginManager().getPlugins()
        .findAll { plugin -> plugin.isPinningForcingOldVersion() }
        .each {
    println "${it.getShortName()};${it.getVersion()};${it.getDisplayName()};${it.getDependencies()}"
}

println "\nDISABLED:\n---"
println "Plugin name;Version;Description;Dependencies"
/**
 * Get Disabled plugins.
 */
Jenkins.instance.getPluginManager().getPlugins()
        .findAll { plugin -> !plugin.isEnabled() }
        .each {
    println "${it.getShortName()};${it.getVersion()};${it.getDisplayName()};${it.getDependencies()}"
}

println "\nINACTIVE:\n---"
println "Plugin name;Version;Description;Dependencies"
/**
 * Get Inactive plugins.
 */
Jenkins.instance.getPluginManager().getPlugins()
        .findAll { plugin -> !plugin.isActive() }
        .each {
    println "${it.getShortName()};${it.getVersion()};${it.getDisplayName()};${it.getDependencies()}"
}
return;