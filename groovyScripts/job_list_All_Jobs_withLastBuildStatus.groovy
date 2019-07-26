jenkins.model.Jenkins.instance.getAllItems(jenkins.model.ParameterizedJobMixIn.ParameterizedJob.class).findAll{job -> !(job.metaClass.methods*.name.findAll{method -> method == "isDisabled"}.isEmpty()) }.findAll{job -> job.disabled}.each{job ->

def className = job.getClass(); 
def lastBuild = job.getLastBuild()? job.getLastBuild().number: "Never built once"; 
def lastBuildOnDate = job.getLastBuild()? job.getLastBuild().getTime():"Never built once"
def url = job.getUrl()
    println "$url~$lastBuild~$lastBuildOnDate~$job.disabled"
}