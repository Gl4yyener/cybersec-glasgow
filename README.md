cybersec-glasgow
================

Assignment at uni of glasgow, in subject Cyber Security.


Assignment text:

Known Plain Text Attack
You will be given a chunk of cipher text, together with the plaintext corresponding to the
first block. Write a program to perform a brute force search of the key space to find the
key. Use this key to decode the rest of the message.
Your report should contain the key you found and the decoded message.

Cipher Text Only Attack
You will be given another chunk of cipher text, as above, but no plaintext. You will need
to perform a brute force attack as before, knowing that the plaintext is an English
language message. You will also need to perform an experiment to find out how many
cipher text blocks were needed to decode the message unambiguously.
Your report should contain the key you found and the decoded message. You should also
include a theoretical calculation of the number of blocks of cipher text needed before
unambiguous decoding is possible, together with the actual number of blocks needed for
your particular message, as found by your experiment.

Time Memory Tradeoff
You will be given the first plaintext block, which you should use to construct a time
memory tradeoff table. This table should be written to a file, and the simplest way of
doing this is to write the entries as two integers per line.
Some time later you will be given the full cipher text, and your second program should
read in the table entries from the file, construct the table, obtain the first cipher text block,
discover the key and decode the rest of the cipher text.
Since the time-memory tradeoff is a probabilistic attack, it is possible that the key I have
used is not in your table. In this case, run the table generating program again with
different random values and try again.
