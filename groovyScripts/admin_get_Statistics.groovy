import com.cloudbees.hudson.plugins.folder.Folder
// Script won't work without above method that comes from Cloudbees plugin
import groovy.transform.Field
import hudson.model.Job
import hudson.model.User
import jenkins.model.*

// Basic Variables
j = Jenkins.instance
@Field Set projects = []
@Field HashMap count_by_type = [:]
count = j.getAllItems(Job.class).size()
jobs_with_builds = j.getAllItems(Job.class)*.getNextBuildNumber().findAll { it > 1 }.size()
global_total_builds = j.getAllItems(Job.class)*.getNextBuildNumber().sum { ((int) it) - 1 }
j.getAllItems(Job.class).each { i ->
    count_by_type[i.class.simpleName.toString()] = (count_by_type[i.class.simpleName.toString()])? count_by_type[i.class.simpleName.toString()]+1 : 1
    if(i instanceof Job) {
        projects << "${i.fullName.split('/')[0]}/${i.displayName.split(' ')[0]}"
    }
}

//organizations = j.getAllItems(Folder.class).size()
// We dont use GitHub projects
total_users = User.getAll().size()

//display counted information
println "Jenkins basic statistics"
println '-' * 80
//println "Number of GitHub Organizations: ${organizations}"
// We dont use GitHub projects
println "Number of Git based Projects: \t${projects.size()}"
println "Number of Jenkins Jobs: \t${count}"
println "Number of Jenkins Jobs with more than one Build: ${jobs_with_builds}"
println "Global total number of Builds: \t${global_total_builds}"
println '-' * 80
println "Count of projects by type:"
count_by_type.each {
    println "\t - ${it.key}: ${it.value}"
}
println '-' * 80
println "Number of Users: ${total_users}"