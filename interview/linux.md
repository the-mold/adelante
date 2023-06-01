## Cron jobs
Cron jobs are repetitive tasks in a UNIX based systems.
1. Check current cron jobs for your user:
```
crontab -l
```
2. Create a script file `date-script.sh`
```
#!/bin/sh
echo `date` >> /Users/petromoldovan/projects/cronjob/date-out.txt
```
3. open crontab list for editing:
```
crontab -e
```
Add a cron job to run every minute:
```
*/1 * * * * /bin/sh /Users/petromoldovan/projects/cronjob/date-script.sh
```
4. Save it and see that the file `date-out.txt` is updated every minute.
