import hudson.model.User
User.getAll().each { user ->
println user.getId()}
