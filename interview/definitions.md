# Authentication

Process of verifying(username-password, bio measure, ctyptographic key) identity of user, system
or device that tries to access the resource.

Popular Authentication mechanisms:

1. SSO(single sign on) - mechanism that allows users to authenticate once and access different org
   resources(different apps). After first authentication token is stored on user device and attached to
   every request.
2. OAuth(Open Authorization) - grant a third party applications the access to resources on a web server(eg facebook) without sharing credentials with the third party app.
Implementation:
- some thirdparty app needs data from your facebook.
- the thirdparty app makes authorisation request to FB with client ID that thirdparty app knows.
- you see the facebook screen where you allow app the thirdparty app to access your data on facebook.
- you click "yes" and facebook sends a "authorisation code" to thirdparty app.
- thirdparty app makes a request with clientID, clientSecret and code to facebook again. In return thirdparty app gets an access token.
- With access token the thirdparty app retrieves(Authorisation: Bearer access_token) user information from facebook.

3. OpenID Connect - is built on top of OAuth authorisation but it also adds authentication possibilities(id token that allows to access user profile).


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

# Open Policy Agent(OPA)

Decouples policy and decission making in a service to a separate layer. Uses Rego language to define
policies(resource access, filter possibility etc).

OPA intercepts every request and checks if the request fulfills policy requirements. In this way,
applications do not need to have policy and access logic. Applications can concentrate solely on
business logic.

# Web certificates

Goals:

1. Verify website owner.
2. Establish secure encrypted connection between user's browser and th website.

Certificates are issues by third party Certificate Authorities(CA). CA checks the website owner and issues
the signed certificate.

It is possible to make own certificate(aka self-signed certificate). Self-signed certificate enables encrypted
connection for users but does not verify the owner of the website. Self-signed certs are used mostly
in development.

IDS Firewall
