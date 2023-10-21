# Ch9 Archiving and compressing

Archiving - gathering few files in one archive. Arhive size will be a bit bigger that sum of file sizes becuase archive adds some overhead.
tar -cvf NewArchiveName.tar ./file1 ./file2 ./file3

Compressing - decreasing files in size.
Best(highest compression rate) Linux algorithm is
bzip2 ./NewArchiveName.tar

To unzip:
buzip2 ./NewArchiveName.tar.bz2

# Ch5 Permissions

## Set user ID(SUID)

Some programs need to have root priviledges even though the programs are ran by simple users. For example, if
program allows users to change passwords, program needs access to the /etc/shadow file that require root prviledges.
You may set SUID on the program file. It means that EVERY user can execute the program with root priviledges but these
priviledges do not extend beyond the use of that file.
Set it by prepanding `4` before file permissions. For example file has `644`, the do:

```
chmod 4644 ./file.sh
```

## Set group ID(SGID)

Temporarily grants permissions of the file owner's group. For example, if the SGID bit is set, someone without execute permission,
can execute the file if file's owner belongs to a group that has permission to execute that file. Set it by prepanding `2` before file permissions.
