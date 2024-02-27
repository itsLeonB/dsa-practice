import hmac
import hashlib
import time
import struct


def main():
    userid = "user@mail.com"
    secret_suffix = "SECRET007"
    shared_secret = userid + secret_suffix
    timestep = 30
    T0 = 0
    passwd = totp(shared_secret, 10, T0, timestep).zfill(10)
    return passwd


def hotp(k, c, digits=10):
    """HOTP:
    k is the shared key
    c is the counter value
    digits control the response length
    """
    k_bytes = k.encode()
    c_bytes = struct.pack(">Q", c)
    hmac_sha512 = hmac.new(key=k_bytes, msg=c_bytes, digestmod=hashlib.sha512).hexdigest()
    return truncate(hmac_sha512)[-digits:]


def truncate(hmac_sha512):
    """truncate sha512 value"""
    offset = int(hmac_sha512[-1], 16)
    binary = int(hmac_sha512[(offset * 2):((offset * 2) + 8)], 16) & 0x7FFFFFFF
    return str(binary)


def totp(k, digits=10, timeref=0, timestep=30):
    """TOTP, time-based variant of HOTP
    digits control the response length
    the C in HOTP is replaced by ( (currentTime - timeref) / timestep )
    """
    c = int(time.time() - timeref) // timestep
    return hotp(k, c, digits=digits)


if __name__ == "__main__":
    main()