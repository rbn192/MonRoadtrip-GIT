import { DOCUMENT } from '@angular/common';
import { Inject, Injectable, Renderer2 } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ScriptService {
  constructor(@Inject(DOCUMENT) private document: Document) {}

  public load(renderer: Renderer2): HTMLScriptElement {
    const script = renderer.createElement('script');
    script.type = 'module';
    script.src = '/assets/js/scriptMarqueur.js';
    renderer.appendChild(this.document.body, script);
    return script;
  }
}
