import jenkins.model.Jenkins
import groovy.json.JsonBuilder
import groovy.json.JsonOutput

def json = new JsonBuilder().plugins {}
def plugins = jenkins.model.Jenkins.instance.getPluginManager().getPlugins().stream().sorted()

for (p in plugins){
  j = new JsonBuilder().plugin {
    "${p.getShortName()} ${p.getVersion()}" "DEPENDS_ON: ${p.getDependencies()}"
  }
  json.plugins << j.plugin
}

println(new JsonBuilder(json.plugins).toPrettyString())