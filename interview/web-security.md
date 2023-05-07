# Single Origin Policy(SOP)

By default, browsers forbid cross origin(host+port) requests. SOP allows resources to be embedded(images, iframes, styles, script, video, audio, form) but does not allow cross-origin reading. This is a security feature and is done avoide the following:

- User has two browser tabs open: one is malicious website and the other one is online bank. User loggs into banking and receives cookie that is stored in the browser. WITHOUT SOP, malicious website could send requests to
  the banking app from another tab(because cookie would be attached by the browser).
- Malicious browser opens an iframe where victim logs into banking webapp. WITHOUT SOP, malicious website could send requests to the banking app using the received cookie (because cookie would be attached by the browser).

# How to relax SOP

## Cross Origin Resource Sharing(CORS)

Server configuration that uses HTTP Access-Control-Allow-Origin response header to allow requests from different origins. You set in server which URLS are legit one and only those URLS can access the server from browser. Normally, browsers send OPTIONS request to check if a website may access a server.

## JavaScript document.domain

If you have a domain(example.com) and a bunch of subdomains(login.example.com, store.example.com) and you need to share resource among them, set this in javascript everywhere:

```
document.domain = "example.com"
```

## JSOP(old way)

Because embeded requests are allowed in SOP, this technique suggests creating a `<script>` tag, attaching it to dome(and therefore loading the script) on the fly(dynamically). Server returns a json and in inside a function call:

```
myFunc({id: 1, name: "bla"})
```

If you have defined the function `myFunc` previously, then it will get executed with the JSON input.

Source: https://www.w3schools.com/js/js_json_jsonp.asp

# Web Attacs

## Cross-site scripting(XSS)

Vulnarability that allows injecting JS code into website somehow, so that when a legitimate user visits the website, this JS code will execute in context of the user's session.
Hackers can:

- Steal user data. Send user data as well as bank info to a malicious server.
- Phishing attack/Steal user login credentials. The injected JS script can redirect user to another page with login that looks exactly like the one from the visited website. When user enters credentials, they are stolen.
- Modify content of the website where JS was injected.

## Cross-Site Request Forgery (CSRF)

Vulnerability that allows an attacker to trick a user into performing an unwanted action on a website, without the user's knowledge or consent.
Attack:

1. Attacker creates a website or sends an email with a link.
2. Victim clicks on the link that triggers a request to a target website(online trader).
3. Browser attaches automatically user cookie to the request.
4. If target website is insecure and does not check the request origin and does not have other means of authorisation, the request performs some unwanted action on behalf of the user: buying something, changing password, stealing data.

## Clickjacking

Intercepting user click on a legit website and doing things with the click event.

1. Hacker creates a website with a harmless button.
2. Button is overlayed by an invisible iframe where a target website's button is clicked.
3. Hacker intercepts this click event with JS and performs malicious stuff with it: making purchases,
   redirecting user, stealing data etc.
