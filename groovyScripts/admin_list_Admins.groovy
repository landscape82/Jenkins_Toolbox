import jenkins.model.*
import hudson.model.User

allUsers = User.getAll()
adminList = []

for (user in allUsers) {
    if (user.hasPermission(Jenkins.ADMINISTER)) {
        adminList.add(user)
    }
}
println(adminList)