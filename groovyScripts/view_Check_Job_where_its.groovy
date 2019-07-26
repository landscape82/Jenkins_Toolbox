import hudson.model.Job

job_name = 'FR_144_PACKAGE-BUILD-INSTALLERS'
found_views = []

views = hudson.model.Hudson.instance.views

for (view in views){
  for (job in view.items) {
    if (job.name.equals(job_name)){
      found_views << view.name
    }
  }
}

println String.format("Job '%s' is included to: %s", 
                  job_name, 
                  found_views.sort().join(', '))