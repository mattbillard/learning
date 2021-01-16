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
- Iframe (very isolated/encapsulated)
  - Dimensions: determined by parent
  - Almost everything is isolated
    - JS can pass through if both are running on the same domain or use the same `document.domain = 'xxxxx';`
  - Shared vs isolated
    - CSS: isolated
    - URL: isolated
    - JS global vars: isolated
    - DOM selectors: isolated 
    - events: only window.postMessage
    - localStorage: only shared for same domain with same port
    - sessionStorage: only shared for same domain with same port
    - Cookies: shared? Needs more investigation
- Shadow DOM (very porous)
  - Dimensions: determined by child
  - Almost everything except CSS and HTML selectors are porous 
  - Shared vs isolated
    - CSS: isolated
    - URL: shared
    - JS global vars: shared
    - DOM selectors: isolated
    - events: shared (except they seem to come from the shadow root, not the actual target)
    - localStorage: shared
    - sessionStorage: shared
    - Cookies: shared
  - Sounds great in theory...
    - Does an incredible job isolating CSS very easily but...
    - JavaScript becomes very difficult
      - I have found no good way for JS in the shadow DOM to find its context, the equivalent of "window" for itself
      - This makes finding DOM nodes from inside a JS shadow DOM, extremely difficult
      - Comments from others indicate 3rd party libraries have problems because of stuff like this

