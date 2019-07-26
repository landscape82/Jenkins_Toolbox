import jenkins.model.Jenkins
  
println("=== Regular Slave Executors:")
println '-' * 70;
  
// Jenkins Master and slaves
def regularSlaves = Jenkins.instance.computers.grep{ 
  it.class.superclass?.simpleName != 'AbstractCloudComputer' &&
  it.class.superclass?.simpleName != 'AbstractCloudSlave' &&
  it.class.simpleName != 'EC2AbstractSlave'
  }
int regularSlaveExecutorCount = regularSlaves.inject(0, {a, c -> a + c.numExecutors})

println("Node Name; Type; Executors") 
regularSlaves.each {
  println "${it.displayName}; ${it.class.simpleName}; ${it.numExecutors}" 
  }
println '-' * 40;
println("Total: " + regularSlaveExecutorCount + " executors")
println()

println("=== Shared Slave Executors:")
println '-' * 70;
  // CJOC Shared Slaves
  def sharedSlaves = Jenkins.instance.allItems.grep{
    it.class.name == 'com.cloudbees.opscenter.server.model.SharedSlave' 
  }
  int sharedSlaveExecutorCount = sharedSlaves.inject(0, {a, c -> a + c.numExecutors})

println("Node Name; Type; Executors")
  sharedSlaves.each {
    println "${it.displayName}; ${it.class.simpleName}; ${it.numExecutors}"
  }
println '-' * 40;
println("Total: " + sharedSlaveExecutorCount + " executors")
println()

println("=== Container Slave Executors")
println '-' * 70;
println("Container Name; Type; Max. Executors")
  int totalInstanceCaps
  Jenkins.instance.clouds.each { cloud ->
      Integer instanceCaps
      try{
        instanceCaps = cloud.templates?.inject(0, {a, c -> a + (c.numExecutors * c.instanceCap)})
        totalInstanceCaps += instanceCaps
      }catch(e){
      }finally{
      }
    println "${cloud.displayName}; ${cloud.descriptor.displayName}; ${instanceCaps ?: ''}"
  }
println '-' * 40;
  if(totalInstanceCaps != null && totalInstanceCaps > 0){
    println("Total: up to " + totalInstanceCaps + " executors")
  } else {
    println("Total: None")
  }
  return