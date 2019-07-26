import jenkins.model.*

println "Running plugin count:"
println ""
def plugins = jenkins.model.Jenkins.instance.getPluginManager().getPlugins().stream().sorted()
plugins.each {println "${it.getShortName()}: ${it.getVersion()}"}
println ""
def plugins_total = jenkins.model.Jenkins.instance.getPluginManager().getPlugins()
println "Total number of plugins: ${plugins_total.size()}"