// Get API Token for Jenkins CLI authentication
// change line variable in 'hudson.model.User.get('USERNAME or JENKINS ID')
// then run it to receive present TOKEN

import jenkins.model.Jenkins
user = hudson.model.User.get('jpodgors')
prop = user.getProperty(jenkins.security.ApiTokenProperty.class)
println(prop.getApiToken())
