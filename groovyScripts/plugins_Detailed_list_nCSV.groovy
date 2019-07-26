println "Jenkins - Master Instance:"
println '-' * 80
println "FQDN: ${InetAddress.localHost.canonicalHostName} \tIP Address: ${InetAddress.localHost.hostAddress}"
println ""
println "Installed Plugins (Alphabeticaly sorted):"
println '-' * 80
jenkins.model.Jenkins.instance.getPluginManager().getPlugins().stream().sorted().each
{ println "NAME: ${it.getShortName()} | VERSION: ${it.getVersion()} | DESCRIPTION: ${it.getDisplayName()} | DEPENDENCY: ${it.getDependencies()}" }

// { println "NAME: ${it.getShortName()} | VERSION: ${it.getVersion()} | DESCRIPTION: ${it.getDisplayName()} \nDEPENDENCY: ${it.getDependencies()}\n" }