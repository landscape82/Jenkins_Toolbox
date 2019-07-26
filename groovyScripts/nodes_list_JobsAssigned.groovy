import jenkins.model.*
import hudson.model.*

jenkins = Hudson.instance;
urlBase = jenkins.getRootUrl()

for (slave in hudson.model.Hudson.instance.slaves) {
   boolean projectsFound = false;
   count = 0;
   println('---')
   println('Name: ' + urlBase + 'computer/' + slave.name);
   println('Executors: ' + slave.getNumExecutors());
   println('Remote FS Root: ' + slave.getRemoteFS());
   println('Mode: ' + slave.getMode());
   println('Descriptor: ' + slave.getDescriptor());
   println('Computer: ' + slave.getComputer());
   println('---')
   labels = slave.getAssignedLabels()
   labels.each() {
      if(it.getTiedJobs().empty){
         println("No projects tied to this label: " + it)
      }
      else{
         println('Jobs tied to label: ' + it + ' \n' + it.getTiedJobs())
         count = count + 1;
      }
   }
   if(slave.getComputer().getTiedJobs().empty){
      println("No projects tied to this node");
   }
   else{
      println('TiedJobs: ' + slave.getComputer().getTiedJobs());
      count = count + 1;
   }
   if(count != 2){
      println(" *** There are no projects tied to this node *** ")
   }
} 
return 0