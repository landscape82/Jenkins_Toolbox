import jenkins.model.Jenkins

def masterIP = InetAddress.localHost.hostAddress
println "Jenkins master Node is running on following server:"
println "Master FQDN:\t\t${InetAddress.localHost.canonicalHostName}"
println "hostname -i".execute().text
println "Master IP Address:\t${masterIP}"