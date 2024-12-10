# Wordpress
For eCommerce you need WooCommerce(free plugin) plugin. But you have to pay for other things like mailing, hosting etc. 
All in all it is cheaper with wordpress than shopify. 

# Shopify
You do not develop, you just click it togather. Everything is done by shopify: emailing, payments, order management etc.
For one user shop it is 27Eur per month but next tier with 5 users is 80. Additionally for EVERY transaction you pay shopify ca 2.5% depending on a plan.

## wordpress.com VS wordpress.org
wordpress.com is very limited and not flexible solution. Hosting is done for you but the word "wordpress" appeaars in domain name.
You want wordpress.org. Here you can do whatever you want.

## Installation locally

# How to migrate WP from local to remote machine?
1. Add plugin duplicator to your local instance
2. run the plugin to get two files: something like initializor and .zip archive.
3. Load the two files to remote machine.
4. Open them in browser and run installation. Note: you need a running mysql db to complete the setup.
5. You can remove the files after installation.

Alternative way(manual) and better not do that:
https://www.udemy.com/course/wordpress-for-ecommerce/learn/lecture/28425568#overview


## Speed optimization
See udemy: WordPress Speed Optimization Course.
You need to use plugins for caching. With these you will improve SEO and search rankings.
Possible plugins
WPRocket - Premium plugin - The best plugin 
Perfmatters - Premium plugin - use coupon code RICKY for an extra 20% off
Litespeed Cache - Free plugin

# image loading
Plugin Smush - lazy load - Premium plugin - It will start costing once you have many images.

# Automatic backups
UpdraftPlus Wordpress backup plugin - Free
With the plugin you can do automatic backups(files+db) that will be saved in some cloud storage that you select(google drive).
Also whenever you do updates of plugins, make a backup manually. If smth goes wrong, you can always roll back.

# Security
Wordfence Security - Premium plugin but with free plan

# Google analitics
Go to elementor -> custom code -> insert snippet from google analitics

# Google search console
Add TXT DNS record to domain records(done in domain provider website)

#TODO: what for?
ping list 
https://docs.google.com/document/d/17rQmTNzzyqVBypi7uYguA8lkXFuTetHqDq1YkjfuA5M/edit?tab=t.0

# SEO
1. You need identify some keywords for you business. If you start in highly competity business, make your keywords precise. Ex not "frying pan" but "best frying pan for eggs".

To find your keywords:
Chrome plugin "keywords everywhere".
Chrome plugin "keyword surfer".


Tools that do seo analysis for you:
SEMrush. Not cheap but really good approach. See how the guy does it in Lecture 113.

2. Place your keywords in content, metatags, image alt text.
3. Offsite SEO: link yor webpage to a number of other pages.
Creating backlinks: https://backlinko.com/high-quality-backlinks#2-publish-skyscraper-content
4. For wordpress use the RankMath plugin. It is premium but with free version.


# Email marketing
The highest ROI you get from email marketing. Second place SEO.
Connect seninblue with its own plugin + mailoptin plugin.

# Payment providers
## Paypal
1. Install plugin "WooCommerce PayPal Payments"
2. Go to WooCommerse -> Settings -> Payments
3. Activate your account
4. Disable cards paypemnts via paypal. You will cover it with Stripe

## Stripe
1. Install plugin "WooCommerce Stripe Payment Gateway"
2. Go to plugins -> WooCommerce Stripe Payment Gateway -> Settings
3. Create stripe account.
4. In stripe go to developers -> API keys -> Create a new key. Add key to wordpress plugin settings.
5. From wordpress plugin settings copy webhook url and create a new webhook in stripe. 
See how the guy does it in 72.


# Insert custom posts into Wordpress
1. Install Secure Custom Fields(old ACF)
2. Add new post type. (Note! in advance activate archive option to enable list view!)
3. Add new field group and assign them to your new post type.
4. In WP admin go to your new Post type and add new items.

Render list page:
Note! I am not sure if this is correct method!
1. Install code snippets plugin and write a custom function that renders your post types.
https://www.youtube.com/watch?v=pxPoOAx4wtk

Render details page:
1. WP admin -> templates -> single post(before saving it constraint it only for your post type) -> add fields and click on "Dynamic fields" when choosing value.
https://www.youtube.com/watch?v=1ahazbL0ZMs


# Product variation selection 
Use plugin(variation swatches) to show variations nicely:
https://wordpress.org/plugins/woo-variation-swatches/

# Product image flipper in list when hovered
https://en-gb.wordpress.org/plugins/tp-product-image-flipper-for-woocommerce/

# Infinite scroll in product list
https://wordpress.org/plugins/catch-infinite-scroll/

# Wishlist
also a plugin :(

# Product slider
https://wordpress.org/plugins/woocommerce-products-slider/

# Currency switcher
many plugins