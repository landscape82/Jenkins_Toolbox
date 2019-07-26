import hudson.model.Job
import jenkins.model.Jenkins

// Basic Variables
j = Jenkins.instance
allprojects = [:]

Jenkins.instance.getAllItems(Job.class).each { Job jenkins ->
    String jclass = jenkins.class.simpleName
    if(!(jclass in allprojects)) {
        allprojects[jclass] = 0
    }
    allprojects[jclass]++
}
println "Count Projects by type:"
println '-' * 40
allprojects.each { k, v ->
    println "- ${k}: ${v}"
}

global_total_builds = j.getAllItems(Job.class)*.getNextBuildNumber().sum { ((int) it) - 1 }
println "Global total number of Builds: \t${global_total_builds}"
null