@echo off
wsl "$(wslpath '%~dpn0')" %*
