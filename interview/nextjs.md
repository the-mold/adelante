# react 
React is for highly dynamic apps, like airbnb or instagram. Many settings that load data in background, change view, etc

# NextJS
Is expending React to static apps.
Create a new app:
```
 npx create-next-app@latest
```
select all Yes answers, except for the "customize default alias"

Start app:
```
npm run dev
```

Quick deployment with Vercel(company that develops nextjs)
```
npx vercel
```

Add DB:
```
1. Add sqlite with prisma
npx prisma init --datasource-provider sqlite
2. add models in schema.prisma
3. run migration to implement changes
npx prisma migrate dev
```

Important in nextjs is client VS server components.
1. They both are rendered on the server only once!!! Server sends an html to browser and if there are any client components redered, browsers makes another request to server to fetch JS for the client components.
2. Use client components only when you need to use hooks or event handlers. Add "use client" on top of the js file to declare client component. By default all components are server components.

## Production build and test
```
npm run build
#by default very aggressive caching is applied. See which pages are marked as static and change them to dynamic if you need to.
npm run start
```