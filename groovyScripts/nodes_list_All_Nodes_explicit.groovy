import jenkins.model.Jenkins
import hudson.model.*

// def command = 'free -h| grep mem'
// def output = ['bash', '-c', command].execute().text

for (aSlave in hudson.model.Hudson.instance.slaves) {
println('Name: \t' + aSlave.name);
println '-' * 70;
println('Label of Node: \t' + aSlave.getLabelString());
println('Number of Executors: ' + aSlave.getNumExecutors());
println('Running Mode: \t' + aSlave.getMode());
println('Remote FleSystem: \t' + aSlave.getRemoteFS());
println('Root Path/Workspace: \t' + aSlave.getRootPath());
println('Descriptor: \t' + aSlave.getDescriptor());
println('Computer Type: \t' + aSlave.getComputer());
println('Computer Type: \t' + aSlave.collect());

// TODO
//println command.execute().text

// TODO...
//println('\tcomputer.isAcceptingTasks: ' + aSlave.getComputer().isAcceptingTasks());
//println('\tcomputer.isLaunchSupported: ' + aSlave.getComputer().isLaunchSupported());
//println('\tcomputer.getConnectTime: ' + aSlave.getComputer().getConnectTime());
//println('\tcomputer.getDemandStartMilliseconds: ' + aSlave.getComputer().getDemandStartMilliseconds())

// If NODE is offline or null object i/o error will occur
//println('\tcomputer.isOffline: ' + aSlave.getComputer().isOffline());
//println('\tcomputer.countBusy: ' + aSlave.getComputer().countBusy());

// Logs it to explicit
//println('\tcomputer.getLog: ' + aSlave.getComputer().getLog());

// Builds output is too explicit - Long output - do not execute it as java.io error will occur
//println('\tcomputer.getBuilds: ' + aSlave.getComputer().getBuilds());
println ' '
}