hudson.model.Hudson.instance.getView('<provide project name>').items.each(){ 
  println  "${it.fullName}; ${it.fullDisplayName}"
}
