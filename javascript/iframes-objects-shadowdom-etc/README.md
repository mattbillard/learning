# Comparing Iframes, Object, and Shadow DOM


- Iframe and object tags appear to be indistinguishable for HTML
- Iframe vs Shadow DOM
  - Iframe (very encapsulated)
    - Dimensions: determined by parent
    - URL: not shared
    - CSS: not shared
    - JS global vars: not shared
    - events: only post message
    - localStorage: only shared for same domain with same port
    - sessionStorage: only shared for same domain with same port
    - Cookies: shared? Needs more investigation
  - Shadow DOM (very porous)
    - Dimensions: determined by child
    - URL: shared
    - CSS: shared
    - JS global vars: shared
    - events: shared (except they seem to come from the shadow root, not the actual target)
    - localStorage: shared
    - sessionStorage: shared
    - Cookies: shared
