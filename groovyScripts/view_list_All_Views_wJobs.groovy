// List all views / added to it jobs available in Jenkins Instance
// For import use ';' as a separator

import jenkins.model.Jenkins

println 'View name;Job Name'
Jenkins.instance.views.each { 
  view ->
  //println "${view.name}"
  view.items.each {
    item ->
    println "${view.name};${item.name}"
  }
}
return