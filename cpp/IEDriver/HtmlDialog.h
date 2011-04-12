#ifndef WEBDRIVER_IE_HTMLDIALOG_H_
#define WEBDRIVER_IE_HTMLDIALOG_H_

#include <exdispid.h>
#include <exdisp.h>
#include <mshtml.h>
#include <mshtmdid.h>
#include "DocumentHost.h"

using namespace std;

namespace webdriver {

struct DialogWindowInfo {
	HWND hwndOwner;
	HWND hwndDialog;
};

class HtmlDialog : public DocumentHost, public IDispEventSimpleImpl<1, HtmlDialog, &DIID_HTMLWindowEvents2>  {
public:
	HtmlDialog(IHTMLWindow2* window, HWND hwnd, HWND session_handle);
	virtual ~HtmlDialog(void);

	static inline _ATL_FUNC_INFO* DocEventInfo() {
		static _ATL_FUNC_INFO kDocEvent = { CC_STDCALL, VT_EMPTY, 1, { VT_DISPATCH } };
	  return &kDocEvent;
	}

	BEGIN_SINK_MAP(HtmlDialog)
		SINK_ENTRY_INFO(1, DIID_HTMLWindowEvents2, DISPID_HTMLWINDOWEVENTS2_ONBEFOREUNLOAD, OnBeforeUnload, DocEventInfo())
		SINK_ENTRY_INFO(1, DIID_HTMLWindowEvents2, DISPID_HTMLWINDOWEVENTS2_ONLOAD, OnLoad, DocEventInfo())
	END_SINK_MAP()

	STDMETHOD_(void, OnBeforeUnload)(IHTMLEventObj* pEvtObj);
	STDMETHOD_(void, OnLoad)(IHTMLEventObj* pEvtObj);

	void GetDocument(IHTMLDocument2** doc);
	void Close(void);
	bool Wait(void);
	HWND GetWindowHandle(void);
	std::wstring GetWindowName(void);
	std::wstring GetTitle(void);
	HWND GetActiveDialogWindowHandle(void);
	HWND GetTopLevelWindowHandle(void);

	int NavigateToUrl(const std::wstring& url);
	int NavigateBack(void);
	int NavigateForward(void);
	int Refresh(void);

private:
	static BOOL CALLBACK FindChildDialogWindow(HWND hwnd, LPARAM arg);

	void AttachEvents(void);
	void DetachEvents(void);

	bool is_navigating_;
	CComPtr<IHTMLWindow2> window_;
};

} // namespace webdriver

#endif // WEBDRIVER_IE_HTMLDIALOG_H_
