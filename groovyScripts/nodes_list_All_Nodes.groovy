import jenkins.model.Jenkins
import hudson.model.*

def jenkins = Jenkins.instance
def servers = jenkins.computers

servers.each{ 
  println "${it.displayName} ${it.hostName} ${it.getNumExecutors()}"
}