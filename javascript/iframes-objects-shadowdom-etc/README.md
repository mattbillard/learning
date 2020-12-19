# Comparing Iframes, Object, and Shadow DOM

## Install and run 
- Run 
  ```
  npm i 
  npm start
  ```
- Open  
  http://localhost:3000/

## Comparisons
- Iframe and object tags appear to be indistinguishable when loading HTML

### Iframes vs Web components / shadow DOM
- Iframe (very issolated/encapsulated)
  - Dimensions: determined by parent
  - Almost everything is issolated
    - JS can pass through if both are running on the same domain or use the same `document.domain = 'xxxxx';`
  - Shared vs issolated
    - CSS: issolated
    - URL: issolated
    - JS global vars: issolated
    - DOM selectors: issolated 
    - events: only window.postMessage
    - localStorage: only shared for same domain with same port
    - sessionStorage: only shared for same domain with same port
    - Cookies: shared? Needs more investigation
- Shadow DOM (very porous)
  - Dimensions: determined by child
  - Almost everything except CSS and HTML selectors are porous 
  - Shared vs issolated
    - CSS: issolated
    - URL: shared
    - JS global vars: shared
    - DOM selectors: issolated
    - events: shared (except they seem to come from the shadow root, not the actual target)
    - localStorage: shared
    - sessionStorage: shared
    - Cookies: shared
