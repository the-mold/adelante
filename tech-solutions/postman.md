API building with postman
1. Enterprise licence is (usually) needed. Currently, you can add only 3 API definitions in all other plans. Also you cannot connect to on-premise gitlab instances with any licence but enterprise.
2. In postman click on APIs and add one with your API definition.
3. You can test and develop with generated requests from the API.
4. Click on a request and click on Scripts to add some tests.
5. You can run tests locally or in CI pipeline(click on share to generate link to your postman collection and execute it in CI pipeline with newman tool).
6. You can connect you API definition with code repository. In non-enterprise licences only non-onpremise code repositories are supported. When repository connection is done, you can pull, update and commit changes to API. So basically all developers can work on API in postman. There is a single source of truth and comfortable usage of API with postman.
7. You can setup postman monitor that will run your tests on API periodically.