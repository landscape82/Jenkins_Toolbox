import hudson.model.*
import jenkins.model.*
// Go to Script Console under Manage Jenkins

// print the name of all jobs including jobs inside of a folder and the folders themselves:

Jenkins.instance.getAllItems(AbstractItem.class).each {
  println(it.fullName)
};

// print the name of all jobs including jobs inside of a folder, but not the folders themselves.
  
Jenkins.instance.getAllItems(Job.class).each{ 
  println it.name + " - " + it.class
}

// print the name of all jobs implementing the AbstractProject class, i.e. Freestyle and Maven jobs.

Jenkins.instance.getAllItems(AbstractProject.class).each {it ->
  println it.fullName;
}