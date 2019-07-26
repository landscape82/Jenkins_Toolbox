import jenkins.model.Jenkins

def jenkins = Jenkins.getInstance()
println "Jenkins version: ${jenkins.getVersion()}"
println "Configured JDKs:\n${jenkins.getInstance().getJDKs()}"
println '-' * 80
println "Connected Nodes:"
jenkins.getNodes().each{ 
  println "${it.displayName};${it.nodeName}"
}
println '-' * 80
println "Configured labels:\n${jenkins.getLabels()}"