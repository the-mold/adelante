# Authentication
Process of verifying(username-password, bio measure, ctyptographic key) identity of user, system 
or device that tries to access the resource.

Popular Authentication mechanisms:
1. SSO(single sign on) - mechanism that allows users to authenticate once and access different org
resources(different apps). After first authentication token is stored on user device and attached to
every request.
2. OAuth(Open Authorization) - grant third party applications the access to resources on a web server(ex facebook)
without sharing credentials with the third party app.
Implementation:
- some thirdparty app needs data from your facebook.
- the thirdparty app makes authorisation request to FB.
- you see the facebook screen where you allow app the thirdparty app to access your
data on facebook.
- you click "yes" and thirdparty app gets a token from FB to fetch your info when the thirdparty app
needs it.
3. OpenID Connect - when user wants to access a resource in a thirdparty app,
user is redirected to identity provider. In identity provider user authenticates himself, then the IDP generates
an identity token that is sent to thirdparty app. The thirdparty app check the tokens and make a decision whether to grant
user can access the resource or not.


# Authorization
Process of determining if a user has a right to access a particular resource or perform an action.
Once user identity was authenticated, the authorization process checks the user permissions.

Popular access control mechanisms:
1. Role-based access control (RBAC) - security model used to control access to the resources based
on roles that users have and NOT user identity. Users are assigned roles that define set of 
permissions. If user tries to access a resource, these roles and/or permissions are checked to
grant the access.
2. Attribute-Based Access Control (ABAC) - access to a resource is granted based on some user
attribute, like job title, location etc.
3. Mandatory Access Control (MAC): very strict model. Access controls are assigned to every single user
separately rather than roles.
