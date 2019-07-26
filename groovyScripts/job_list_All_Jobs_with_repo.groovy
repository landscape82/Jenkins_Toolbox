import jenkins.model.*
import jenkins.scm.*
import hudson.scm.*
import hudson.model.*
import hudson.matrix.*
import com.cloudbees.hudson.plugins.folder.*
import hudson.maven.*
import hudson.scm.subversion.*

jenkins = Hudson.instance
nullSCM = 0
countGit = 0
countP4 = 0
countP42 = 0
countMerc = 0
countSVN = 0
total = 0
overall = 0

Jenkins.instance.getAllItems(AbstractProject.class).each {
  if (!(it instanceof MavenModule || it instanceof MatrixConfiguration)){
    def scm = it.scm
//    if (scm.class.name == 'hudson.plugins.perforce.PerforceSCM') {
//      println "Job:\t'${jenkins.getRootUrl() + it.getUrl()}'\n\tUses the following Perforce configuration:"
//      println '-' * 80
//      println "P4Port:\t${scm.getP4Port()}"
//      println "P4Client:\t${scm.getP4Client()}"
//      println "P4User:\t${scm.getP4User()}"
//      println "P4Password:\t${scm.getP4Passwd()}"
//      countP4++
//      println ''
//        }
//    else 
      if (scm.class.name == 'hudson.plugins.git.GitSCM'){
      println"Job:\t${jenkins.getRootUrl() + it.getUrl()}\n\tUses the following Git configuration:"
      println '-' * 80
      println"URL:\t\t${scm.userRemoteConfigs.url}"
      println"Credentials:\t${scm.userRemoteConfigs.credentialsId}"
      countGit++
      println ''
        }
//    else if(scm.class.name == 'org.jenkinsci.plugins.p4.PerforceScm'){
//      println"Old P4 Job:\t'${jenkins.getRootUrl() + it.getUrl()}]'\n\tUses the following Perforce Software configuration:"
//      println '-' * 80
//     println"Credentials: ${scm.credential}"
//      countP42++
//      println ''
//       }
    else if(scm.class.name == 'hudson.plugins.mercurial.MercurialSCM'){
      println"Job:\t${jenkins.getRootUrl() + it.getUrl()}\n\tUses the following Git configuration:"
      println '-' * 80
      countMerc++
      println ''
        }
    else if(scm.class.name == 'org.jenkinsci.plugins.svn.SubversionSCM' ){
      println"Job:\t'${jenkins.getRootUrl() + it.getUrl()}'\n\tUses the following Git configuration:"
      println '-' * 3
      println"URL:\t\t${scm.userRemoteConfigs.url}"
      println"Credentials:\t${scm.userRemoteConfigs.credentialsId}"
      countSVN++
      println ''
    }
    else{
      nullSCM++
        }
    total++
      }
  overall++
    }
println '=' * 80
println("Total number of items (maven/matrix included):\t" + overall)
println("Total number of jobs based on code repository:\t" + total)
println("Number of jobs not using SCM:\t" + nullSCM)
println("Number of jobs using SCM:\t" + (countGit + countMerc + countSVN))
//println("Number of jobs using SCM: " + (countP4 + countP42 + countGit + countMerc))
//println("		Perforce: " + countP4)
//println("		Perforce Software: " + countP42)
println("\tGit: " + countGit)
println("\tMercurial: " + countMerc)
println("\tSVN: " + countSVN)
return 0
