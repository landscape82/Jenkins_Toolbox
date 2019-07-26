def plugins = jenkins.model.Jenkins.instance.getPluginManager().getPlugins()
List<String> list = new ArrayList<String>()
i = 0
plugins.each {
    ++i
        list.add("${it.getShortName()}: ${it.getVersion()};${it.getDisplayName()};${it.getDependencies()}")
    }

list.sort{it}
i = 0
for (String item : list) {
    i++
        println("${i};${item}")
    }