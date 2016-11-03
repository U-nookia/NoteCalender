# NoteCalender
练手MVP

##apiclient 日期事件包
含有一个与日历相关的事件类

##calender_use  日历类包
有一个日历的base类和继承base类的具体类

##note_model 记事本数据处理包
负责获取记事本的数据
- INoteList 是记事本列表类的接口，由NoteList类具体实现
- NotesAdapter.java 适配recyclerView的适配器

##note_view  记事本视图处理包
- AddView 一个简单的自定义View
- INoteView view类的接口
- NoteView 负责处理View和用户交互的activity

##note_presenter 记事本控制器包
负责将View和Model连接起来  以及进行数据的操作

##util 工具包
